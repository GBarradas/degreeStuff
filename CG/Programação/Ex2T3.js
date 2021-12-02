function square_step(model){
    let distance=Math.sqrt((Math.pow(model.ball.x-model.square.x,2))+(Math.pow(model.ball.y-model.square.y,2)));
    if(distance>=model.alert_distance) model.square.color="steelblue";
    else if(distance<model.alert_distance) model.square.color="orange";
    return model;
}