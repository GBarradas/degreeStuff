function hero_step(model){
    switch(model.motion){
        case 1:
            model.x+=model.step_size;
            break;
        case 2:
            model.x-=model.step_size;
            break;
        case 3:
            model.y-=model.step_size;
            break;
        case 4:
            model.y+=model.step_size;
            break;
        default:
            break;
    }
    return model;
}