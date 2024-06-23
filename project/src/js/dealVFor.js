
export default function dealVFor(obj){
    //v-for,的处理
    //如果存在v-for
            if (obj.attributes['v-for']){
                let vForString = obj.attributes['v-for'];
                let wrods = vForString.split(' ');
                let itemString = '';
                let indexString = '';
                let arrString = '';
                if (wrods[0].includes(",")){
                    wrods[0] = wrods[0].replace(/[(\)]/,"");
                    itemString = wrods[0].split(",")[0];
                    indexString = wrods[0].split(',')[1];
                } else {
                    itemString = wrods[0].replace(/[(\)]/,"");
                }
                arrString = wrods[2];
            }
}