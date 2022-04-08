import axios from "axios";
// import VueJwtDecode from "vue-jwt-decode";
const session = window.sessionStorage;

const state = { 
    search : {
        // 검색 품종 리스트
        list: []
    }
};

// getters
const getters = { 
    
}

// state 상태 변경 mutations
const mutations = { 
    SET_SEARCH_LIST(state, payload){
        state.search.list = payload;
    },
}

const actions = { 
    
    kindSearchList(context, kind) { 
        let headers = {
            'at-jwt-access-token': session.getItem('at-jwt-access-token'),
            'at-jwt-refresh-token': session.getItem('at-jwt-refresh-token'),
        };
        axios({
            method: 'get',
            url: '/api/shel/search/list/' + kind, // /api vue.configjs가 가르키는 주소
            // data: data, // post 나 put에 데이터 넣어 줄때
            headers: headers,  // 넣는거 까먹지 마세요
          }).then((res) => {
            
            this.dispatch('login/accessTokenRefresh', res) // store아닌곳에서 상황에 따라서 메서드가 다르다
    
            context.commit("SET_SEARCH_LIST", res.data);
            
          }).catch((error) => {
            console.log(error);
          })
    },

    searchShelnimal(context, inputText, sex, neuterYn, addr){
        let headers = {
            'at-jwt-access-token': session.getItem('at-jwt-access-token'),
            'at-jwt-refresh-token': session.getItem('at-jwt-refresh-token'),
        };

        const formData = new FormData();
        let data = {
            kind : inputText,
            sex : sex,
            neuterYn : neuterYn,
            addr : addr,
        };

        formData.append(
            "searchData",
            new Blob([JSON.stringify(data)], { type: "application/json" })
        );

        axios({
            method: 'post',
            url: '/api/shel/', // /api vue.configjs가 가르키는 주소
            data: data, // post 나 put에 데이터 넣어 줄때
            headers: headers,  // 넣는거 까먹지 마세요
          }).then((res) => {
            
            this.dispatch('login/accessTokenRefresh', res) // 상황에 따라서 메서드가 다르다
    
          }).catch((error) => {
            console.log(error);
          })
    }
}

export default {
    namespaced: true,
    state,
    getters,
    mutations,
    actions,
};