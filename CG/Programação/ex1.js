const  eqna_s = (x1,y1,x2,y2)=>{
    if(x1===x2 ||y2===y1){
        return null
    }
    if(x1===x2){
        return{
        a:1.0,
        b:0.0,
        c:-x1
        }
    } else{
        let m=-(y2-y1)/(x2-x1)
        let b=y1-m*x1
        return{
            a: -m,
            b: 1.0,
            c: -b
        }
    }

}
console.log(eqna_s(1,1,2,2))
