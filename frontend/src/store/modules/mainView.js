import axios from "axios";
// import VueJwtDecode from "vue-jwt-decode";

const session = window.sessionStorage;

const state = { 
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
const getters = { 
    
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
const mutations = { 
    SET_MAIN_SELIMAL_LIST(state, payload){
        state.shelnimal.list = payload;
    },

    SET_MAIN_SELIMAL_DETAIL(state, payload){
        state.shelnimal.img = payload.img;
        state.shelnimal.age = payload.age;
        state.shelnimal.kind = payload.kind;
        state.shelnimal.character = payload.character;
    }
}

const actions = { 
    
    mainShelnimalList(context) { 
        let headers = {
            'at-jwt-access-token': session.getItem('at-jwt-access-token'),
            'at-jwt-refresh-token': session.getItem('at-jwt-refresh-token'),
        };
        axios({
            method: 'get',
            url: '/api/shel/view/notlogin', // /api vue.configjs가 가르키는 주소
          //   data: data, // post 나 put에 데이터 넣어 줄때
            headers: headers,  // 넣는거 까먹지 마세요
          }).then((res) => {
    
            // this.$store.dispatch('login/accessTokenRefresh', res) // store아닌곳에서 상황에 따라서 메서드가 다르다
            
            console.log(res);

            context.commit("SET_MAIN_SELIMAL_LIST", res.data);
            
          }).catch((error) => {
            console.log(error);
          }).then(() => {
            console.log('getQSSList End!!');
          });
        },
        // axios
        // .get("/shel/view/notlogin")
        // .then(({data}) => {
        //     console.log(data.list);
        //     context.commit("SET_MAIN_SELIMAL_LIST", data.list);
        // });
}

export default {
    namespaced: true,
    state,
    getters,
    mutations,
    actions,
  };