<script setup>
//스크립트에서 사용할 기능들 임폴트 할 자리 : script setup
import axios from 'axios'; // axios
import Growingcomment from '../growing/growingcomment.vue'; //Growingcomment.vue
</script>

<template>
        <div class="gr-home">
                <div class="gr-info">

                        <table id="grinfo_tb">
                                <tbody>
                                        <tr>
                                                <td>그룹 이름</td>
                                                <td>{{ groupInfo[0].grName }}</td>
                                        </tr>
                                        <tr>
                                                <td>그룹 레벨</td>
                                                <td>{{ groupInfo[0].grTier }}</td>
                                        </tr>

                                </tbody>

                        </table>

                </div>

                <div class="gr-nav">
                        <ul>
                                <li> 마을로 이동하기 </li>
                                <li @click=""> 캘린더 </li>
                                <li @click=""> 숲속일기장</li>
                                <li @click="diaries"> 달빛전망대</li>
                                <li @click="growinglist"> 쑥쑥 나무일지</li>
                        </ul>

                </div><!--그룹 정보는 어차피 모두 가지고 있으니까 0번찌에 있는 사람거 가져옴 -->

                <div class="gr-tree">
                        <img src="@/assets/Level1.png" alt="Level1" :class=bounce v-on:mouseover=img_on()
                                v-if="groupInfo[0].grTier == 1" v-on:mouseleave=img_off()>
                        <img src="@/assets/Level2.png" alt="Level2" :class=bounce v-on:mouseover=img_on()
                                v-if="groupInfo[0].grTier == 2" v-on:mouseleave=img_off()>
                        <img src="@/assets/Level3.png" alt="Level3" :class=bounce v-on:mouseover=img_on() v-if="groupInfo[0].grTier == 3" 
                                v-on:mouseleave=img_off()>
                        <img src="@/assets/Level4.png" alt="Level4" :class=bounce v-on:mouseover=img_on() v-if="groupInfo[0].grTier == 4"
                                v-on:mouseleave=img_off()>
                        <img src="@/assets/Level5.png" alt="Level5" :class=bounce v-on:mouseover=img_on() v-if="groupInfo[0].grTier == 5"
                                v-on:mouseleave=img_off()>

                </div>

                <div class="gr-member">


                </div>



        </div>



</template>

<script>


export default {
        data() {
                return {
                        
                        // 'id':'',
                        // 'nick':'',
                        'grNo':1, // 시리얼 넘버로 해놔서 0으로 해도 됨, int니까 숫자 설정 가능, 실제 저장된 데이터 중에 없는 데이터로 해야 됨 : 안 그럼 실행 시 다른 그룹으로 들어가짐 
                        // 'grName':'',
                        // 'grLeader':'',
                        // 'grCount' :'',
                        // 'grMax':'',
                        // 'grCode':'',
                        // 'grTree':'',
                        // 'grTier':'',

                        groupInfo:[], //1. 리스트로 저장한다 -> 그룹에 여러명이 있어서 여러명의 데이터를 띄울 예정이기 때문



                        temp_grNo: 10,


                        bounce: "bounce-top",
                        tree1: true,
                        tree2: false,
                        tree3: false,
                        tree4: false,
                        tree5: false,


                };
        },
        mounted() {
                // let login = JSON.parse(sessionStorage.getItem('login')); //로그인 정보를 가져온다

                // let group = JSON.parse(sessionStorage.getItem('group')); //그룹 번호를 가져온다 

                // if(!login){
                //         alert('로그인이 필요합니다');
                //         //라우터 로그인으로 보낼 자리 
                // }

                //const param 은 get param 은 get방식, post 둘다 필요 params 에 싸서 컨트롤러 매개변수에 접근해서 
                // 타고 타고 xml까지 도달
                const param = {
                        params:{
                                'grNo':this.grNo
                        }
                }


                //Post방식일때는 컨트롤러에 @리퀘스트바디 적거나 , 프론트에서 null 적기 
                axios.post("http://localhost:5959/groupHome", null , {params:{'grNo':this.grNo}}) //{ grNo : group.grNo}) 이 부분은 로그인 후 그룹을 선택 할 때 홈에서 결정 됨으로 홈화면 담당자랑 상의해서 결정해야 한다 
                        .then(resp => {
                                this.groupInfo = resp.data;
                                alert(JSON.stringify(this.groupInfo));
                                
                        }).catch(err=>{
                                // console.error(err);
                        })


                this.bounce = "none";
                // 1. 페이지 로딩 중일때 axios 로 그룹 정보를  변수에 저장하는 함수 하나 만들기 

        },
        methods: {
                img_on() {
                        this.bounce = "bounce-top"
                },
                img_off() {
                        this.bounce = "none";
                }
        },
}
</script>

<style>
.gr-home {
        width: 1600px;
        height: 800px;
        background-image: url('@/assets/grouphome1.png');
        background-repeat: no-repeat;
        background-size: cover;
        background-position-x: center;
        overflow: hidden;
        border-radius: 40.2px;


}

.gr-info {
        width: 400px;
        height: 150px;
        float: left;
        background-image: url('@/assets/groupinfo.png');
        background-repeat: no-repeat;
        background-size: cover;
        background-position-x: center;



}

#grinfo_tb {
        margin: 50px 18px 50px 50px;
        font-size: 17pt;




}

.gr-nav {
        width: 400px;
        height: 600px;
        float: right;
        background-image: url('@/assets/groupmenu.png');
        background-repeat: no-repeat;
        background-size: cover;
        background-position-x: center;
        justify-items: center;


}



.gr-tree {
        width: 300px;
        height: 500px;
        margin: 170px 220px auto;
        float: left;
}

.gr-member {
        width: 1500px;
        height: 200px;
        border: solid 2px;
        background-color: aliceblue;
        margin-top: 600px;
}

img {
        width: 350px;
        height: 400px;
        justify-content: center;
        margin: 10px auto;

}

li {

        list-style-type: none;
        font-size: 20pt;
}

ul {
        margin-top: 100px;

}


.bounce-top {
        -webkit-animation: bounce-top 0.9s backwards;
        animation: bounce-top 0.9s backwards;
}

@-webkit-keyframes bounce-top {
        0% {
                -webkit-transform: translateY(-45px);
                transform: translateY(-45px);
                -webkit-animation-timing-function: ease-in;
                animation-timing-function: ease-in;
                opacity: 1;
        }

        24% {
                opacity: 1;
        }

        40% {
                -webkit-transform: translateY(-24px);
                transform: translateY(-24px);
                -webkit-animation-timing-function: ease-in;
                animation-timing-function: ease-in;
        }

        65% {
                -webkit-transform: translateY(-12px);
                transform: translateY(-12px);
                -webkit-animation-timing-function: ease-in;
                animation-timing-function: ease-in;
        }

        82% {
                -webkit-transform: translateY(-6px);
                transform: translateY(-6px);
                -webkit-animation-timing-function: ease-in;
                animation-timing-function: ease-in;
        }

        93% {
                -webkit-transform: translateY(-4px);
                transform: translateY(-4px);
                -webkit-animation-timing-function: ease-in;
                animation-timing-function: ease-in;
        }

        25%,
        55%,
        75%,
        87% {
                -webkit-transform: translateY(0px);
                transform: translateY(0px);
                -webkit-animation-timing-function: ease-out;
                animation-timing-function: ease-out;
        }

        100% {
                -webkit-transform: translateY(0px);
                transform: translateY(0px);
                -webkit-animation-timing-function: ease-out;
                animation-timing-function: ease-out;
                opacity: 1;
        }
}

@keyframes bounce-top {
        0% {
                -webkit-transform: translateY(-45px);
                transform: translateY(-45px);
                -webkit-animation-timing-function: ease-in;
                animation-timing-function: ease-in;
                opacity: 1;
        }

        24% {
                opacity: 1;
        }

        40% {
                -webkit-transform: translateY(-24px);
                transform: translateY(-24px);
                -webkit-animation-timing-function: ease-in;
                animation-timing-function: ease-in;
        }

        65% {
                -webkit-transform: translateY(-12px);
                transform: translateY(-12px);
                -webkit-animation-timing-function: ease-in;
                animation-timing-function: ease-in;
        }

        82% {
                -webkit-transform: translateY(-6px);
                transform: translateY(-6px);
                -webkit-animation-timing-function: ease-in;
                animation-timing-function: ease-in;
        }

        93% {
                -webkit-transform: translateY(-4px);
                transform: translateY(-4px);
                -webkit-animation-timing-function: ease-in;
                animation-timing-function: ease-in;
        }

        25%,
        55%,
        75%,
        87% {
                -webkit-transform: translateY(0px);
                transform: translateY(0px);
                -webkit-animation-timing-function: ease-out;
                animation-timing-function: ease-out;
        }

        100% {
                -webkit-transform: translateY(0px);
                transform: translateY(0px);
                -webkit-animation-timing-function: ease-out;
                animation-timing-function: ease-out;
                opacity: 1;
        }
}
</style>
