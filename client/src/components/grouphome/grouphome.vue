<template>
    <div class="gr-home"> 
        <div class="gr-info"> 
         
        <table id="grinfo_tb">
                <tbody>
                        <tr>
                        <td>그룹 이름</td><td>{{grName}}</td>
                        </tr>
                        <tr>
                        <td>그룹 레벨</td><td>{{grTier}}</td>      
                        </tr>

                </tbody>

        </table>

        </div>

        <div class="gr-nav">
            <ul>
                <li> 마을로 이동하기 </li>
                <li v-on:click=""> 캘린더 </li>
                <li v-on:click=""> 숲속일기장</li>
                <li v-on:click="diaries"> 달빛전망대</li>
                <li v-on:click="growinglist"> 쑥쑥 나무일지</li>
            </ul>

        </div>
        <div class="gr-tree">
            <img src="@/assets/Level1.png" alt="Level1" :class=bounce v-on:mouseover=img_on() v-if="grTier == 1" v-on:mouseleave=img_off()>
            <img src="@/assets/Level2.png" alt="Level2" :class=bounce v-on:mouseover=img_on() v-if="grTier == 2" v-on:mouseleave=img_off()>
            <img src="@/assets/Level3.png" alt="Level3" :class=bounce v-on:mouseover=img_on() v-show="tree3" v-on:mouseleave=img_off()>
            <img src="@/assets/Level4.png" alt="Level4" :class=bounce v-on:mouseover=img_on() v-show="tree4" v-on:mouseleave=img_off()>
            <img src="@/assets/Level5.png" alt="Level5" :class=bounce v-on:mouseover=img_on() v-show="tree5" v-on:mouseleave=img_off()>

        </div>

        <div class="gr-member">


        </div>



    </div>
 


</template>

<script>
import Growingcomment from '../growing/growingcomment.vue';

export default{
    data() {
        return {
        

        temp_grNo:10,


            bounce: "bounce-top",
            tree1: true,
            tree2: false,
            tree3: false,
            tree4: false,
            tree5: false,
            

        }
    },
    mounted () {
        this.bounce="none";
  // 1. 페이지 로딩 중일때 axios 로 그룹 정보를  변수에 저장하는 함수 하나 만들기 

    },
    methods: {
        img_on() {
            this.bounce="bounce-top"
        },
        img_off(){
            this.bounce="none";
        }
    },
}
</script>

<style>
.gr-home{
    width: 1600px;
    height: 800px;
    background-image: url('@/assets/grouphome1.png');
    background-repeat: no-repeat;
    background-size: cover;
    background-position-x: center;
    overflow: hidden;
    border-radius: 40.2px;
    

}

.gr-info{
    width: 400px;
    height: 150px;
    float: left;
    background-image: url('@/assets/groupinfo.png');
    background-repeat: no-repeat;
    background-size: cover;
    background-position-x: center;
    
   
    
}

#grinfo_tb{
     margin: 50px 18px 50px 50px;
     font-size: 17pt;
     

     
     
}

.gr-nav{
    width: 400px;
    height: 600px;
    float: right;
    background-image: url('@/assets/groupmenu.png');
    background-repeat: no-repeat;
    background-size: cover;
    background-position-x: center;
    justify-items: center;
    
    
}



.gr-tree{
    width:300px;
    height:500px;    
    margin: 170px 220px auto;
    float: left; 
}

.gr-member{
    width: 1500px;
    height:200px;
    border: solid 2px;
    background-color: aliceblue;
    margin-top: 600px;
}

img{
    width: 350px;
    height: 400px;
    justify-content: center;
    margin: 10px auto;
    
}

li{
    
    list-style-type: none;
    font-size: 20pt;
}

ul{
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
