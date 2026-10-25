<template>
    <div class="diarieslist" :style="dlistback">
        <div style="text-align: center;">
            <div style=" margin-top: 60px;">
                <h1 style="margin-bottom: 0; font-family: OngleipParkDahyeon; font-size: 45px; 
                color: #543402; letter-spacing: 5px;">
                    숲속일기장
                </h1>
            </div>
            <div>
                <p style="margin: 0; font-family: OngleipParkDahyeon; font-size: 26px; color: #002A09;">
                    우리는 [ 그룹이름 ] 입니당!</p>
            </div>
            <div class="diarieslist-main">
                <div style="display: flex; flex-direction: row; justify-content: space-between;">
                    <p class="all">지금까지 쓴 일기들:</p>
                    <button class="write">일기쓰기</button>
                </div>

                <div>
                <table class="table" border="1">
                    <colgroup>
                        <col width="50"><col width="50"><col width="120"><col width="900"><col width="80">
                    </colgroup>
                    <thead></thead>
                    <tbody>
                        <tr>
                            <td>O</td>
                            <td>날씨</td>
                            <td>날짜</td>
                            <td>오늘의 한마디</td>
                            <td>작성자</td>
                        </tr>
                        <tr>
                            <td>O</td>
                            <td>날씨</td>
                            <td>날짜</td>
                            <td>오늘의 한마디</td>
                            <td>작성자</td>
                        </tr>
                        <tr>
                            <td>O</td>
                            <td>날씨</td>
                            <td>날짜</td>
                            <td>오늘의 한마디</td>
                            <td>작성자</td>
                        </tr>
                        <tr>
                            <td>O</td>
                            <td>날씨</td>
                            <td>날짜</td>
                            <td>오늘의 한마디</td>
                            <td>작성자</td>
                        </tr>
                        <tr>
                            <td>O</td>
                            <td>날씨</td>
                            <td>날짜</td>
                            <td>오늘의 한마디</td>
                            <td>작성자</td>
                        </tr>
                        <tr>
                            <td>O</td>
                            <td>날씨</td>
                            <td>날짜</td>
                            <td>오늘의 한마디</td>
                            <td>작성자</td>
                        </tr>
                    </tbody>
                </table>
            </div>
            </div>
            
        </div>
    </div>
</template>

<script>
export default {

}
</script>

<style>
.diarieslist {
    width: 1600px;
    height: 800px;
    background-image: url('../../assets/일기장목록배경.png');
    background-repeat: no-repeat;
    background-size: cover;
    background-position-x: center;
    overflow: hidden;
    border-radius: 40.2px;
}

.diarieslist-main {
    width: 650px;
    height: 500px;
    margin: 0 auto;
    /* border: solid 3px; */
}

.all {
    margin: 100px 0;
    font-family: OngleipParkDahyeon;
    font-size: 30px;

}

.write {
    height: 50px;
    margin-top: 90px;
    font-family: OngleipParkDahyeon;
    font-size: 30px;
    border-radius: 10px;
    background-color: blanchedalmond;
    color:#E89F31;
}
.write:hover{
    background-color: rgb(255, 229, 189);
    cursor: pointer;
}
.table{
    margin: auto;
 
}
</style>