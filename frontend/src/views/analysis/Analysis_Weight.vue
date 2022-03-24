<template>
<div>
    <div> 무게 임시 페이지 입니다. 1 </div>
    <div> 임시 페이지 입니다. 2 </div>
    <div> 임시 페이지 입니다. 3 </div>
    <div> 임시 페이지 입니다. 4 </div>
    <div> 임시 페이지 입니다. 5 </div>
    <div> 
        <h1> 무게 통계 </h1>
        <button type="button" class="btn btn-outline-primary" @click="test" > 
            임시
        </button>
    </div>
    <div> 임시 페이지 입니다. 6 </div>
    <div> 임시 페이지 입니다. 7 </div>
    <div> 임시 페이지 입니다. 8 </div>
    <div> 임시 페이지 입니다. 9 </div>
    <div> 임시 페이지 입니다. 10 </div>

</div>  
</template>

<script>

import axios from 'axios'
// const session = window.sessionStorage;

export default {
    name : 'Analysis_Weight',
    data : function() {
        return {

        }
    },
    methods : {
        // 테스트용
        test() {

            console.log("[system] 테스트 통신 시작");

            // let headers = {
            //     'at-jwt-access-token': session.getItem('at-jwt-access-token'),
            //     'at-jwt-refresh-token': session.getItem('at-jwt-refresh-token'),
            // };

            let data = {
            name: '',
            type: ''
            };
            axios({
                method: 'get',
                url: '/api/test',
                data: data, // post 나 put에 데이터 넣어 줄때
            }).then((res) => {
                // this.$store.dispatch('login/accessTokenRefresh', res) // store아닌곳에서
                // this.dispatch('accessTokenRefresh', res) // store에서
                console.log(res);
                console.log("통신 완료");
           
           }).catch((error) => {
                console.log(error);
            }).then(() => {
                console.log('getQSSList End!!');
            });
        
        },
        
        


    }

}
</script>

<style>

</style>