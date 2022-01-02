function message(text){
    let terminal= document.getElementById("terminal");
    terminal.innerHTML=text;
}
function get_cord(){
    return (Math.random()*400);
}
function new_context(){
    let gc = document
    .getElementById("canvas")
    .getContext("2d");
    
    gc.render = render;
    gc.canvas.width = 400;
    gc.canvas.height = 400;
    
    return gc;
}
function render(model){
    if(model.status==1){
        //message(`Paused <br> Time: ${model.time}`);
    }
}
function new_pudle(){
    //let pudle = { 
        //    
        //}
        let person = {
            pos_x: 0, pos_y: 0,
            vel: 0.01, heading: 0,
            state: 0, // 0: healthy, 1: infectious, 2: ill
        };
    
        person.update = person_update;
    
        return person;
}
function person_update(model) {
    switch (this.state) {
        case 0: // healthy
            break;
        case 1: // infectious
            if (rand_ab(0, 1) <= model.p_h_inf) {
                this.state = 0;
                break;
            }

            if (rand_ab(0, 1) <= model.p_ill_inf) {
                this.state = 2;
                break;
            }
            break;
        case 2: // ill
        if (rand_ab(0, 1) <= model.p_h_ill) {
            this.state = 0;
            break;
        }

        if (rand_ab(0, 1) <= model.p_inf_ill) {
            this.state = 1;
            break;
        }
        break;
        default: break;
    }

    let vel = this.vel;
    switch (this.state) {
        case 1: // infectious
            vel = 1.5 * vel;
            break;
        case 2: // ill
            vel = 0.1 * vel;
        default:
            break;
    }
    this.heading += rand_cr(0, Math.PI * 8);
    this.pos_x = clip(this.pos_x + vel * Math.cos(this.heading), 0, 1);
    this.pos_y = clip(this.pos_y + vel * Math.sin(this.heading), 0, 1);
}
function update_pudle(){

}
    function new_model(){
    //let model={
    //    age:0,
    //    time:0,
    //    status:1, //0 plaing //1 stop
    //    pudles: range(100).map(i => new_pudle()),
    //    player:{
    //        x:0,
    //        y:0,
    //        scale: 0.4,
    //        vel:1,
    //        action:0,
    //    },
    //};
    
    //document.addEventListener("keydown", (e) => {
//    switch (e.key) {
    //        case "w": case "W": model.player.action = 1;  model.status=0; break;
    //        case "s": case "S": model.player.action = 2;  model.status=0; break;
    //        case "d": case "D": model.player.action = 3;  model.status=0; break;
    //        case "a": case "A": model.player.action = 4;  model.status=0; break;
    //        case " ": model.status=1;
    //        default: model.player.action = 0; break;
    //    }
    //});
    let model = {
        age: 0,
        paused: false, // 0: PAUSED, 1: RUNNING
        person_size: 0.02,
        infection_distance: 0.1,
        infection_prob: 0.7,
        p_h_inf: 0.01, p_ill_inf: 0.02,
        p_h_ill: 0.001, p_inf_ill: 0.02,        
        population: range(100).map(i => new_person()),
    };

    model.population[0].state = 1;

    model.update = update;

    document.addEventListener("keypress", (e) => {
        if (e.key === " ") model.paused = !model.paused;
    });

    return model;
}
function update() {
    if (this.paused) return;
    this.age++;    
    
    this.population.forEach(p => p.update(this));

    let healthy = this.population.filter(p => p.state === 0);
    let infectious = this.population.filter(p => p.state === 1);
    let ill = this.population.filter(p => p.state === 2);

    for (let p of healthy) {
        let near = infectious.filter(q => distance(p, q) < this.infection_distance);
        for (let q of near) {
            if (rand_ab(0, 1) <= this.infection_prob) p.state = 1;
            if (p.state === 1) break;
        }
    }
}    
function update_model(){
    
}
function main() {
    let gc = new_context();
    message("after gc")
    let pud=new_pudle();
    message("I'm Alive.");
    let model = new_model();
    message("model create whith sucess.");
    let step = (ts) => {
        model.update();
        gc.render(model);
        requestAnimationFrame(step);
    }
    
    requestAnimationFrame(step);
}