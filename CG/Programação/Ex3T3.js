function moon_step(model){
    model.moon.x=model.earth.x+model.d*Math.cos(model.moon.a);
    model.moon.y=model.earth.y+model.d*Math.sin(model.moon.a);
    return model;
}