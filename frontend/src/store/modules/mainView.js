import axios from "axios";
// import VueJwtDecode from "vue-jwt-decode";

const session = window.sessionStorage;

const state = { 
    shelnimal : {
        // 메인 추천
        list: []
    }
};

// getters
const getters = { 
    
    getList: function (state) {
        return state.list;
    },

}

// state 상태 변경 mutations
const mutations = { 
    SET_MAIN_SELIMAL_LIST(state, payload){
        state.shelnimal.list = payload;
    },
}

const actions = { 
    
    mainShelnimalList(context) { 
      
        // let headers = {
        //     'at-jwt-access-token': session.getItem('at-jwt-access-token'),
        //     'at-jwt-refresh-token': session.getItem('at-jwt-refresh-token'),
        // };
        axios({
            method: 'get',
            url: '/api/shel/view/notlogin', // /api vue.configjs가 가르키는 주소
            // data: data, // post 나 put에 데이터 넣어 줄때
            // headers: headers,  // 넣는거 까먹지 마세요
          }).then((res) => {
    
            // this.$store.dispatch('login/accessTokenRefresh', res) // store아닌곳에서 상황에 따라서 메서드가 다르다
            

            context.commit("SET_MAIN_SELIMAL_LIST", res.data);
            
          }).catch((error) => {
            console.log(error);
          })
        },

        mainShelnimalListLogin(context) { 
          
            let headers = {
                'at-jwt-access-token': session.getItem('at-jwt-access-token'),
                'at-jwt-refresh-token': session.getItem('at-jwt-refresh-token'),
            };
            axios({
                method: 'get',
                url: '/api/authorization/shel/view/login/' + JSON.parse(session.getItem('userInfo')).no, // /api vue.configjs가 가르키는 주소
                // data: , // post 나 put에 데이터 넣어 줄때
                headers: headers,  // 넣는거 까먹지 마세요
              }).then((res) => {
        
                this.dispatch('login/accessTokenRefresh', res) // 상황에 따라서 메서드가 다르다
                
    
                context.commit("SET_MAIN_SELIMAL_LIST", res.data);
                
              }).catch((error) => {
                console.log(error);
              })
            },

        
}

export default {
    namespaced: true,
    state,
    getters,
    mutations,
    actions,
  };