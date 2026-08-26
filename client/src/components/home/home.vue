<template>
    <div class="home">
        <h1 class="home-text-h1">일기 마을에 오신 걸 환영해요</h1>
        <br/>
        <h2 class="home-text-h2">도토와 함께 오늘의 이야기를 기록해봐요</h2>
        <br/>
        <h2 class="home-text-h2">도토는 당신의 이야기가 궁금해요</h2>
        <br/>
        <h2 class="home-text-h2">도토는 그런 아이예요</h2>
        <br/>
        <h2 class="home-text-h2">도토는 참지 않아요</h2>
        <br/>
        <h2 class="home-text-h2">"훔쳐보는 일기가 제일 재밌다."</h2>
        <h2 class="home-text-h2-1">-도토-</h2>
        <br/>
        <button class="home-btn" @click="btn_click"> &nbsp;▶ 도토가 훔쳐볼 일기 쓰러 가기 🍃</button>
    </div>
</template>

<script>
export default {
    
    
  
}
</script>

<style>
.home{
    width: 1600px;
    height: 800px;
    background-image: url('../../assets/home1.png');
    background-repeat: no-repeat;
    background-size: cover;
    background-position-x: center;
    overflow: hidden;
    border-radius: 40.2px;
}
.home-text-h1{
    font-family: OngleipParkDahyeon;
    font-size: 70px;
    font-weight: 100;
    color:#fff;
    text-shadow: 0 0 5px #F5B519, 0 0 10px #F5B519, 0 0 15px #548B0D, 0 0 20px #548B0D, 0 0 0px #548B0D;
    margin: 100px auto auto 200px;
}
.home-text-h2{
    font-family: OngleipParkDahyeon;
    font-size: 30px;
    font-weight: 100;
    color:#fff;
    text-shadow: 0 0 5px #F5B519, 0 0 10px #F5B519, 0 0 15px #548B0D, 0 0 20px #548B0D, 0 0 0px #548B0D;
    margin: 10px auto auto 210px;
}
.home-text-h2-1{
    font-family: OngleipParkDahyeon;
    font-size: 30px;
    font-weight: 100;
    color:#fff;
    text-shadow: 0 0 5px #F5B519, 0 0 10px #F5B519, 0 0 15px #548B0D, 0 0 20px #548B0D, 0 0 0px #548B0D;
    margin: 10px auto auto 500px;
}
.home-btn{
    font-family: OngleipParkDahyeon;
    font-size: 30px;
    font-weight: 100;
    color:#5F3407;
    background-color: #F8EDD6;
    border-radius: 30px;
    margin: 10px auto auto 200px;
}
.home-btn:hover{
    cursor: pointer;
    box-shadow: 0 0 5px #F5B519, 0 0 10px #F5B519, 0 0 15px #548B0D, 0 0 20px #548B0D, 0 0 0px #548B0D;
    background-color: #F8EDD6;
}
</style>