const state = {
    sum:0,
}



const getters = {
    bigSum(state){
        return state * 10;
    }
}

//访问 this.$store.state.getters.bigSum

import {mapState} from "vuex"
import {mapGetters} from 'vuex'

const x = mapState({he:"sum"},{});
const y = mapState(['sum',])
let a = {...x};