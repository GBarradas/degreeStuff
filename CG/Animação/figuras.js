function message(text){
    let terminal=document.getElementById("terminal");
    terminal.innerHTML=text;
}
function begin_ref(dx,dy,sx,sy,a){
    this.save();
    this.traslate(dx,dy);
    this.scale(sx,sy);
    this.rotate(a);
}



function end_ref(){
    this.restore();
}
function init_model(){

    return {
        age: 0,
        figuras: {
            shape: {},
            style: {fill: "crimson", stroke: "Kawaki",lineWidth: 0.01},
            transform: {
                dx: 0,dy: 0,
                sx: 1, sy: 1,
                a:0
            },
            children: []

        }
    };
}
function render(model){
        let msg='AGE: '+model.age+".";
        message(msg);

        this.fillStyle='SkyBlue';
        this.fillRect(0,0,128,128);
    }
function update(model){
    model.age+=1;
    //model.figures[0].transform.a+=0.01;
    return model;
}
function animate(gc){
    let model=init_model();
    let step = (ts) => {
        model = update(model);
        gc.render(model);
        requestAnimationFrame(step);
    }
    requestAnimationFrame(step);
}

function main(){
    message('it\'s ok');
    let gc=document
                .getElementById("canvas")
                .getContext("2d");
    gc.render=render;
    //gc.begin_ref=begin_ref;
    animate(gc);

}