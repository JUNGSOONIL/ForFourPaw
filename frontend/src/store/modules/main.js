import http from 'axios'
const state = { // eslint-disable-line no-unused-vars
    shelnimal : {
        // 메인 추천
        list: [],
        // 사진
        img : null,
        // 품종
        kind : null,
        // 나이
        age : null,
        // 특징
        character : null,
    }
};

// getters
const getters = { // eslint-disable-line no-unused-vars
    
    getList: function (state) {
        return state.list;
    },

    getImg: function (state) {
        return state.img;
    },

    getKind: function (state) {
        return state.kind;
    },

    getAge: function (state) {
        return state.age;
    },

    getCharacter: function (state) {
        return state.character;
    },

}

// state 상태 변경 mutations
const mutations = { // eslint-disable-line no-unused-vars
    SET_MAIN_SELIMAL_LIST(state, payload){
        state.shelnimal.list = payload.data;
    },

    SET_MAIN_SELIMAL_DETAIL(state, payload){
        state.shelnimal.img = payload.img;
        state.shelnimal.age = payload.age;
        state.shelnimal.kind = payload.kind;
        state.shelnimal.character = payload.character;
    }
}

const actions = { // eslint-disable-line no-unused-vars
    mainShelnimalList(context) { 
        http
        .get("/shel/view/notlogin")
        .then(({data}) => {
            context.commit("SET_MAIN_SELIMAL_LIST", data.list);
        });
            

    }
}