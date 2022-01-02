function render_svg(model) {
    let element = document.createElementNS(
        "http://www.w3.org/2000/svg",
        model.tag);

    if (model.hasOwnProperty("children")) {
        for (let child_spec of model.children) { // child_spec is a VALUE
            let child = render_svg(child_spec);
            element.appendChild(child);
        }
    }

    if (model.hasOwnProperty("attributes")) {
        for (let attr in model.attributes) {  // attr is an INDEX
            element.setAttribute(
                attr,
                model.attributes[attr]);
        }
    }
    return element;
}

function create_model() {
    return {
        tag: 'svg',
        attributes: {
            width: 256,
            height: 256,
        },
        children: [
            {
                tag: 'g',
                attributes: {
                    transform: "translate(32, 32)",
                },
                children: [
                    {
                        tag: 'path',
                        attributes: {
                            fill: "seagreen",
                            d: "M 0 0 L 128 64 L 0 128 Z"
                        }
                    },
                    {   tag: 'rect',
                        attributes: {
                            fill: "crimson",
                            x: 16,
                            y: 16,
                            width: 64,
                            height: 32,
                        },
                    },
                    {   tag: 'rect',
                        attributes: {
                            fill: "khaki",
                            x: 16,
                            y: 64,
                            width: 64,
                            height: 32,
                        },
                    },
                ]
            }
        ]
    };
}

function main() {
    let model = create_model();
    let svg_element = render_svg(model)

    let basket1 = document.getElementById("basket1");
    basket1.appendChild(svg_element);

    let basket2 = document.getElementById("basket2");
    basket2.innerText = ser.serializeToString(svg_element.outerHTML);
}