<template>
    <div id="regi">
        <h1>회원가입</h1>
        <br/>
        <table border="1">
            <colgroup>
                <col width="180px">
                <col width="200px">
                <col width="100px">
            </colgroup>
            <tbody>
                <!-- 아이디 입력창 -->
                <tr>
                    <th>아이디(필수)</th>
                    <td>
                        <input v-model="id" @input="idRe" size="20" placeholder="아이디(필수)" />
                        <br/>
                    </td>
                    <td><input type="button" @click="idcheck" value="아이디 중복 확인" /></td>
                </tr>
                <!-- 아이디 중복 문구 -->
                <tr>
                    <td colspan="3">
                        <p :style="idChk" style="font-size: 12px">{{  }}</p>
                    </td>
                </tr>
                <!-- 비밀번호 입력창 -->
                <tr>
                    <th>비밀번호(필수)</th>
                    <td>
                        <input v-if="!showPw" v-model="pw" type="password" @input="showPw" size="20" placeholder="비밀번호 입력(필수) "/>
                        <input v-else v-model="pw" type="text" @input="showPw" size="20" placeholder="비밀번호 입력(필수) "/>
                    </td>
                    <!-- 비밀번호 표시/숨김-->
                    <td>
                        <button v-if="!showPw" @click="showPw = true">표시</button>
                        <button v-else @click="showPw = false">숨김</button>
                    </td>

                </tr>
                <!-- 비밀번호 재입력창 -->
                <tr>
                    <th>비밀번호 재입력(필수)</th>
                    <td>
                        <input v-if="!showPwConfirm" v-model="pwConfirm" type="password" @input="pwConfirm" size="20" placeholder="비밀번호 재입력(필수) "/>
                        <input v-else v-model="pwConfirm" type="text" @input="pwConfirm" size="20" placeholder="비밀번호 재입력(필수) "/>
                    </td>
                    <!-- 비밀번호 표시/숨김-->
                    <td>
                        <button v-if="!showPwConfirm" @click="showPwConfirm = true">표시</button>
                        <button v-else @click="showPwConfirm = false">숨김</button>
                    </td>
                </tr>
                <!-- 비밀번호 재확인 불일치 문구 -->
                <tr>
                    <td colspan="3">
                        <p :style="pwChk" style="font-size: 12px">{{  }}</p>
                    </td>
                </tr>
                <!-- 이름 입력창-->
                <tr>
                    <th>이름(필수)</th>
                    <td><input v-model="name" size="20" placeholder="이름 입력(필수)"/></td>
                </tr>
                <!-- 닉네임 입력창-->
                <tr>
                    <th>닉네임(선택)</th>
                    <td><input v-model="nick" size="20" placeholder="닉네임 입력(선택)"/></td>
                </tr>
                <!-- 전화번호 입력 창 -->
                <tr>
                    <th>전화번호(필수)</th>
                        <td>
                            <div class="phone">
                                <input v-model="phone1" @input="makePhone" size="1" placeholder="010" maxlength="3" />
                                -
                                <input v-model="phone2" @input="makePhone" size="2" placeholder="1234" maxlength="4" />
                                -
                                <input v-model="phone3" @input="makePhone" size="2" placeholder="5678" maxlength="4" />
                            </div>
                        </td>
                    </tr>
            </tbody>
        </table>
    </div>
</template>

<script>
import axios from "axios";

export default {
    name : "UsersRegi",

    data() {
        return {
            idChk: "",
            idChkStr: "사용할 수 있는 아이디 입니다.",
            iderr: false,

            pwChk: "",
            pwStr: "비밀번호가 일치하지 않습니다.",
            pwerr: false,

            id: "",         // 아이디
            pw: "",         // 비밀번호
            pwConfirm: "",  // 비밀번호 재확인
            name: "",
        }
    },
}
</script>