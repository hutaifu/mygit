import Vue from "vue";
import vuex, {mapMutations} from "vuex"

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
import {mapMutations} from 'vuex'

const x = mapState({he:"sum"},{});
const y = mapState(['sum',])
let a = {...x};


//模块化
const config1 = {
    namespaced:true,
    actions:{},
    mutations:{},
    state:{},
    getters:{}
}
const config2 = {
    namespaced:true,
    actions:{},
    mutations:{},
    state:{},
    getters:{}
}


export default new Vuex.Store({
    modules:{
        a:config1,
        b:config2,
    }
})

mapMutations("a",{increament:"JIA"})
this.$sotre.commit('a/ADD',"personObj")
this.$sore.getters['a/bigNum']