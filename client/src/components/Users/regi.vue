<template>
  <div id="regi">
    <h1>회원가입</h1>
    <br />
    <table border="1">
      <colgroup>
        <col width="180px" />
        <col width="200px" />
        <col width="100px" />
      </colgroup>
      <tbody>
        <!-- 아이디 입력창 -->
        <tr>
          <th>아이디(필수)</th>
          <td>
            <input v-model="id" @input="reid" size="20" placeholder="아이디(필수)" />
          </td>
          <td>
            <input type="button" @click="idcheck" value="아이디 중복 확인" />
          </td>
        </tr>
        <!-- 아이디 중복 문구 -->
        <tr>
          <td colspan="3">
            <p :style="idChk" style="font-size: 12px">{{ idChkStr }}</p>
          </td>
        </tr>
        <!-- 비밀번호 입력창 -->
        <tr>
          <th>비밀번호 입력(필수)</th>
          <td colspan="2">
            <input
              type="password"
              @input="pwRe"
              v-model="pw"
              size="20"
              placeholder="비밀번호 (필수)"
            />
          </td>
        </tr>
        <!-- 비밀번호 재입력창 (수정: td 태그 추가) -->
        <tr>
          <th>비밀번호 재입력(필수)</th>
          <td colspan="2">
            <input
              type="password"
              @input="pwRe"
              v-model="rw"
              size="20"
              placeholder="비밀번호 재확인 (필수)"
            />
          </td>
        </tr>
        <!-- 비밀번호 재확인 불일치 문구 -->
        <tr>
          <td colspan="3">
            <p :style="pwChk" style="font-size: 12px">{{ pwStr }}</p>
          </td>
        </tr>
        <!-- 이름 입력창-->
        <tr>
          <th>이름(필수)</th>
          <td colspan="2">
            <input v-model="name" size="20" placeholder="이름 입력(필수)" />
          </td>
        </tr>
        <!-- 닉네임 입력창-->
        <tr>
          <th>닉네임(선택)</th>
          <td colspan="2">
            <input v-model="nick" size="20" placeholder="닉네임 입력(선택)" />
          </td>
        </tr>
        <!-- 전화번호 입력 창 -->
        <tr>
          <th>전화번호(필수)</th>
          <td colspan="2">
            <div class="phone">
              <input
                v-model="phone1"
                @input="makePhone"
                size="1"
                placeholder="010"
                maxlength="3"
              />
              -
              <input
                v-model="phone2"
                @input="makePhone"
                size="2"
                placeholder="1234"
                maxlength="4"
              />
              -
              <input
                v-model="phone3"
                @input="makePhone"
                size="2"
                placeholder="5678"
                maxlength="4"
              />
            </div>
          </td>
        </tr>
        <!-- 회원가입 버튼 -->
        <tr>
          <td colspan="3">
            <button @click="sineUp">회원가입</button>
          </td>
        </tr>
        <!-- 로그인으로 돌아가기 -->
        <tr>
          <td colspan="3">
            <a href="/login">로그인</a>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "UsersRegi",

  data() {
    return {
      idChk: "display: none;", // 기본적으로 숨김 처리
      idChkStr: "", // 아이디 중복 문구
      iderr: false, // 아이디 중복 검사 결과 (통과 시 true)

      pwChk: "display: none;", // 비밀번호 재확인 문구
      pwStr: "", // 비밀번호 재확인 문구
      pwerr: false, // 비밀번호 재확인 검사 결과 (통과 시 true)

      id: "", // 아이디
      pw: "", // 비밀번호
      rw: "", // 비밀번호 재확인 (pwConfirm -> rw로 통일)
      name: "", // 이름
      nick: "", // 닉네임
      phone1: "010",
      phone2: "",
      phone3: "",
      phone: "", // 핸드폰번호

      auth: 2,
      canRegi: false, // 회원가입 검사 결과
    };
  },
  methods: {
    // 아이디 중복 확인 버튼
    idcheck() {
      if (this.id !== null && this.id.trim() !== "") {
        axios
          .post("http://localhost:5959/getUsers", null, {
            params: { id: this.id },
          })
          .then((resp) => {
            // 중복되는 아이디가 있을 경우
            if (resp.data === true) {
              this.idChkStr = "사용할 수 없는 아이디 입니다.";
              this.idChk = "display: block; color: red";
              this.iderr = false;
            } else {
              // 중복되는 아이디가 없을 경우
              this.idChkStr = "사용 가능한 아이디 입니다.";
              this.idChk = "display: block; color: blue";
              this.iderr = true;
            }
          })
          .catch((err) => {
            alert(err);
          });
      } else {
        alert("아이디를 입력해 주세요.");
      }
    },
    // 아이디 중복 검사 후 입력된 아이디를 변경한 경우
    reid() {
      this.iderr = false;
      this.idChk = "display: none;";
    },
    // 비밀번호 실시간 입력 및 일치 여부 확인
    pwRe() {
      if (!this.rw || this.rw.trim() === "") {
        this.pwChk = "display: none;";
        this.pwerr = false;
        return;
      }

      if (this.pw !== this.rw) {
        this.pwStr = "비밀번호가 일치하지 않습니다.";
        this.pwChk = "display: block; color: red";
        this.pwerr = false;
      } else {
        this.pwStr = "비밀번호가 일치합니다.";
        this.pwChk = "display: block; color: blue";
        this.pwerr = true;
      }
    },
    // 핸드폰 번호 취합
    makePhone() {
      this.phone = this.phone1 + "-" + this.phone2 + "-" + this.phone3;
    },
    // 회원가입 전 유효성 검사
    regiChk() {
      this.canRegi = false;

      if (this.id === null || this.id.trim() === "") {
        alert("아이디를 입력해주세요.");
        return;
      }
      if (this.iderr === false) {
        alert("아이디 중복 확인을 진행해주세요.");
        return;
      }
      if (this.pw === null || this.pw.trim() === "") {
        alert("비밀번호를 입력해주세요.");
        return;
      }
      if (this.rw === null || this.rw.trim() === "") {
        alert("비밀번호 재입력을 입력해주세요.");
        return;
      }
      if (this.pwerr === false) {
        alert("비밀번호가 일치하지 않습니다.");
        return;
      }
      if (this.name === null || this.name.trim() === "") {
        alert("이름을 입력해주세요.");
        return;
      }
      if (!this.phone1 || !this.phone2 || !this.phone3) {
        alert("전화번호를 올바르게 입력해주세요.");
        return;
      }

      // 휴대폰 번호 데이터 최종 갱신
      this.makePhone();
      this.canRegi = true;
    },
    // 회원가입 버튼 클릭 이벤트 핸들러
    sineUp() {
      this.regiChk();

      if (this.canRegi) {
        const param = {
          params: {
            id: this.id,
            pw: this.pw,
            name: this.name,
            nick: this.nick,
            hp: this.phone,
            auth: this.auth,
          },
        };

        axios
          .post("http://localhost:5959/addUsers", null, param)
          .then((resp) => {
            if (resp.data) {
              alert("축하합니다! 회원가입이 완료되었습니다!");
              this.$router.push({ name: "login" });
            }
          })
          .catch((err) => {
            alert(err);
          });
      }
    },
  },
};
</script>
