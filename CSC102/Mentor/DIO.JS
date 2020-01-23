

function DiO() {
    let str = 'block'
    const half = str.length/2;
    const len = str.length-1;
    var regex = /dog/gi;
    if(len%2==0){
        result = str.substring(half,half+2);
    }

    if(len%2!=0){
        result = str.substring(half, half+3);
    }

    //if(result.includes('o')){
        str.replace('o','oo');
    //}

    console.log(str);
}

DiO();