프로젝트 공통 개발 규칙 · 2026.10.24

문서 상태: 팀 배포용 1차 확정본 \| 확정 스택: Monorepo / Java 17 / JavaScript / main·develop·feature / PostgreSQL

# 문서의 적용 원칙

- MUST: 병합 전 반드시 지키는 규칙. 예외 발생 시 팀 합의와 기록이 필요하다.

- SHOULD: 원칙적으로 따르되 근거를 PR에 남기고 예외 적용할 수 있다.

- TBD: 기능 정책이나 설계가 확정되지 않아 추후 결정할 사항이다.

- 코딩 컨벤션은 기능 요구사항을 대신하지 않는다. API 계약 및 DB 변경은 문서와 코드를 함께 갱신한다.

# 1. 확정 기술 스택 및 저장소

| 영역         | 기술 / 규칙                                   | 상태                       |
|--------------|-----------------------------------------------|----------------------------|
| 형상 관리    | 단일 Git Monorepo; main + develop + feature   | MUST                       |
| 프론트엔드   | JavaScript; Vue 3 + Vite + Vue Router + Axios | MUST                       |
| 백엔드       | Java 17; Spring Boot + MyBatis(XML)           | MUST                       |
| 데이터베이스 | PostgreSQL                                    | MUST                       |
| 게임 표현    | Phaser 3; 주민 로직은 렌더링과 분리           | SHOULD                     |
| 코드 검증    | ESLint, Prettier, 테스트 및 PR 검토           | SHOULD → 초기 세팅 시 강제 |
| 추가 선택    | 인증 방식, 스토리지, CI 제공자, 배포 플랫폼   | TBD                        |

# 2. 리포지토리 구조

doto-diary/

frontend/

public/assets/characters/ \# 캐릭터 스프라이트 시트

public/assets/maps/ \# 타일맵 JSON

public/assets/tilesets/ \# 배경 타일

src/api/ \# Axios 래퍼 및 기능별 API

src/components/ \# 재사용 UI

src/composables/ \# 재사용 Composition API

src/game/{scenes,entities,ai,behaviors,systems}/

src/router/ src/stores/ src/views/ src/utils/

backend/

src/main/java/com/dotodiary/

src/main/resources/mapper/

src/test/

database/migrations/

docs/{conventions,api,architecture,decisions}/

.editorconfig .gitignore README.md

- MUST: frontend와 backend는 독립적으로 빌드할 수 있어야 한다.

- MUST: 자격증명·토큰·개인정보·대용량 원본 에셋을 Git에 무심코 커밋하지 않는다.

- SHOULD: PR 한 건은 기능적 변경 범위를 최소화한다. 공통 코드 변경 시 영향받는 담당자에게 공유한다.

# 3. 명명 규칙 및 파일 포맷

| 대상               | 형식                   | 예시                               |
|--------------------|------------------------|------------------------------------|
| Java 클래스 / DTO  | PascalCase             | DiaryService, DiaryCreateRequest   |
| Java 필드 / 메서드 | camelCase              | createdAt, createDiary()           |
| Java 상수          | UPPER_SNAKE_CASE       | MAX_ISLAND_MEMBERS                 |
| Vue 파일           | PascalCase             | DiaryCard.vue                      |
| JS 변수 / 함수     | camelCase              | isLoading, fetchDiaries()          |
| API 경로           | 복수 명사 + kebab-case | /api/v1/islands/{islandId}/members |
| DB 테이블/컬럼     | 단수 snake_case        | island_member, created_at          |
| Git 브랜치         | 타입/간단한-kebab-case | feature/island-invite              |
| 에셋 파일          | 소문자 snake_case      | pengi_walk.png                     |

- MUST: UTF-8 / LF 개행 / 파일 끝 개행을 사용한다.

- MUST: 동일한 개념은 user, island, resident, diary, character_type처럼 동일 용어로 통일한다.

- MUST: 거북 이름(임시명 노아)을 클래스명·테이블명에 고정하지 않는다.

- SHOULD: 프론트엔드 들여쓰기 2칸, Java 4칸. 자동 포매터를 우선한다.

# 4. 프론트엔드 Vue 규칙

- MUST: Vue Single File Component는 \<script setup\> + Composition API를 사용한다.

- MUST: 화면 컴포넌트에 HTTP 설정 또는 SQL 지식을 넣지 않는다. API 모듈을 통해 호출한다.

- MUST: props는 읽기 전용; 부모 상태 변경은 emit으로 전달한다.

- MUST: v-for는 안정적인 고유 key를 사용한다. v-html로 사용자 원문을 출력하지 않는다.

- SHOULD: 공유 상태는 Pinia, 컴포넌트 지역 상태는 ref/reactive, 공유 로직은 composables/로 분리한다.

- SHOULD: 화면은 Loading / Empty / Error / Success 상태를 명시적으로 지원한다.

// src/api/islandApi.js

import { httpClient } from './httpClient'

export async function fetchMyIslands() {

const { data } = await httpClient.get('/users/me/islands')

return data.data

}

// src/api/httpClient.js

import axios from 'axios'

export const httpClient = axios.create({

baseURL: import.meta.env.VITE_API_BASE_URL,

timeout: 10000

})

참고: 인증 실패, 공통 오류 코드 표시 및 재시도 정책은 Axios 인터셉터에서 중앙 처리하되, 재시도 가능한 요청만 대상으로 한다.

# 5. Java / Spring Boot 규칙

com.dotodiary/

common/{config,exception,response,security}/

auth/{controller,service,dto}/

user/{controller,service,mapper,dto,domain}/

character/{controller,service,mapper,dto,domain}/

island/{controller,service,mapper,dto,domain}/

diary/{controller,service,mapper,dto,domain}/

simulation/{service,dto}/

- MUST: Controller는 라우팅, 권한 확인 진입점, @Valid 요청 검증, HTTP 응답만 다룬다.

- MUST: Service가 비즈니스 규칙과 트랜잭션 경계를 담당한다.

- MUST: Mapper는 DB 접근 인터페이스이며 SQL은 MyBatis XML에 둔다.

- MUST: API 요청/응답 DTO와 DB 조회 DTO/Domain 객체를 구분한다. 비밀번호 해시 등 민감 필드는 응답에 포함하지 않는다.

- MUST: 전역 예외 처리(@RestControllerAdvice)로 오류 코드를 일관되게 반환한다.

- MUST: 변경이 필요한 로직은 @Transactional 범위를 명시한다. 조회 전용은 readOnly=true를 권장한다.

- SHOULD: 생성자 주입, 명확한 메서드명, 과도한 범용 Service/Util 클래스 금지.

@RestController

@RequestMapping("/api/v1/islands")

@RequiredArgsConstructor

public class IslandController {

private final IslandService islandService;

@GetMapping("/{islandId}/members")

public ResponseEntity\<ApiResponse\<List\<IslandMemberResponse\>\>\> getMembers(

@PathVariable Long islandId) {

return ResponseEntity.ok(ApiResponse.success(

islandService.getMembers(islandId)));

}

}

예시의 ApiResponse, IslandService 등은 설계상 클래스이며 실제 프로젝트에서 생성해야 한다.

# 6. MyBatis 및 SQL 규칙

- MUST: Mapper 인터페이스 메서드와 XML의 namespace/id를 정확히 일치시킨다.

- MUST: SQL 값은 \#{parameter}를 사용한다. \${} 사용은 검증된 화이트리스트 식별자에 한정한다.

- MUST: Java camelCase 필드에 대한 조회 컬럼은 AS 별칭 또는 명시적 resultMap으로 매핑한다.

- MUST: SELECT \*를 기본 조회에 사용하지 않는다. 페이징·정렬은 일관된 기준을 갖춘다.

- MUST: 사용자의 섬 접근 권한은 모든 일기·섬 조회 및 변경 요청에서 서버 측 검증한다.

- SHOULD: Mapper XML 파일명은 인터페이스명과 일치시킨다. 예: IslandMapper.xml.

\<select id="findById" resultType="com.dotodiary.island.dto.IslandResponse"\>

SELECT island_id AS islandId,

island_name AS islandName,

created_at AS createdAt

FROM island

WHERE island_id = \#{islandId}

\</select\>

# 7. 데이터베이스 규칙

| 영역         | 팀 규칙                                                             |
|--------------|---------------------------------------------------------------------|
| 명명         | 테이블 단수 snake_case, 컬럼 snake_case                             |
| 기본키       | 의미 있는 {entity}\_id; 규칙을 문서에서 일관 적용                   |
| 외래키       | 참조 테이블 기본키 이름을 따른다                                    |
| 시간         | created_at, updated_at / TIMESTAMPTZ 권장                           |
| 제약         | NOT NULL, UNIQUE, FK, CHECK를 가능한 DB 수준에서 보장               |
| 마이그레이션 | database/migrations에 순서·목적 명시, 배포 후 스키마 수동 수정 금지 |
| 비밀정보     | 비밀번호 원문 저장 금지; 민감정보 최소 수집                         |

- MUST: 섬당 정원 및 사용자당 소속 섬 수 제한은 동시 가입 요청에서도 지켜져야 한다. 원자성 확보 전략(락·제약 등)은 상세 설계에서 결정한다.

- MUST: 일기 공개 범위·그룹 탈퇴·섬 삭제 정책에 따라 조회 권한과 데이터 보존 처리를 함께 설계한다.

- TBD: 삭제/환생 데이터 보존기간, 공개범위 기본값, 파일 저장소.

# 8. REST API 계약

- MUST: /api/v1 접두어와 리소스 중심 복수형 경로를 사용한다.

- MUST: GET 조회, POST 생성, PATCH 부분 수정, DELETE 삭제를 기본 원칙으로 한다.

- MUST: HTTP 상태 코드와 공통 JSON 응답 포맷을 함께 사용한다.

- MUST: 리스트 API에는 페이지 크기 상한과 정렬 기준을 명시한다.

- MUST: 사용자 소속·소유 권한을 서버에서 검증한다. 클라이언트가 전달한 userId를 인증 정보로 취급하지 않는다.

- SHOULD: 공통 오류 코드 목록을 docs/api에 관리한다.

// 성공 (HTTP 200)

{ "success": true, "data": { "islandId": 1 }, "error": null }

// 실패 예: 제한 초과 (적절한 4xx)

{ "success": false, "data": null,

"error": { "code": "ISLAND_LIMIT_EXCEEDED",

"message": "가입 가능한 섬 수를 초과했습니다." } }

| 작업       | 메서드 | 경로                               |
|------------|--------|------------------------------------|
| 내 섬 목록 | GET    | /api/v1/users/me/islands           |
| 섬 만들기  | POST   | /api/v1/islands                    |
| 섬 구성원  | GET    | /api/v1/islands/{islandId}/members |
| 일기 목록  | GET    | /api/v1/islands/{islandId}/diaries |
| 일기 작성  | POST   | /api/v1/islands/{islandId}/diaries |
| 일기 수정  | PATCH  | /api/v1/diaries/{diaryId}          |

# 9. 프로젝트 고유 정책과 연결

- 확정: 사용자 계정은 최대 3개 거북섬에 소속될 수 있다.

- 확정: 캐릭터는 심리테스트로 배정되며 가입 확정 전 재응시를 허용한다.

- 확정: 노아는 임시 명칭이므로 거북 이름은 그룹별 입력 가능한 값으로 설계한다.

- 확정: 사용자는 주민을 직접 조종하지 않고 자율 생활을 관찰한다. 온라인/오프라인 혼합형으로 존재한다.

- TBD: 거북섬 성장의 시각적 방식, 테스트 재응시 이후 결과 보존, 가입 이후 캐릭터 변경, 섬 탈퇴·해체·환생 정책.

# 10. Phaser / 주민 AI 컨벤션

- MUST: 주민 의사결정(Brain/Behavior)과 그래픽 렌더링(Scene/Sprite)을 분리한다.

- MUST: AI 행동 상태는 공통 열거 상수(예: IDLE, WALK, REST, SOCIAL, FARM, WRITE_DIARY)로 관리한다.

- MUST: 시뮬레이션 연출과 실제 사용자 이벤트(일기 작성, 접속 등)는 구별한다.

- MUST: 프레임 타이밍과 이동 위치를 분리해서 애니메이션을 처리한다.

- SHOULD: 반복 재생 가능한 의사결정 로직은 가능한 한 렌더링과 무관하게 테스트한다.

- SHOULD: 초기에는 프론트 시뮬레이션, 영속 데이터만 백엔드 저장. 공통 실시간 동기화는 별도 설계.

export const RESIDENT_ACTION = Object.freeze({

IDLE: 'IDLE', WALK: 'WALK', REST: 'REST',

SOCIAL: 'SOCIAL', FARM: 'FARM', WRITE_DIARY: 'WRITE_DIARY'

})

# 11. 스프라이트 · 게임 에셋 규칙

- MUST: 캐릭터별 최소 4방향(Down/Left/Right/Up)·방향별 4프레임의 PNG 시트를 관리한다. 필요 시 행동별 시트를 추가할 수 있다.

- MUST: 프레임은 동일한 행·열 순서로 배치한다. 순서 변경 시 메타데이터도 함께 갱신한다.

- MUST: 이미지의 실제 프레임 크기와 캐릭터의 게임 내 렌더 크기를 구분한다.

- MUST: 투명 RGBA, 발 중앙 기준점, 잘림 없는 외곽, 귀·꼬리·발 사이 투명 영역을 검수한다.

- MUST: 검은색 / 초록색 / 밝은색 배경에서 누끼 검수한 뒤 에셋을 승인한다. 품질 기준은 승인된 펭이 v4 이상.

- SHOULD: PNG 1장 + 메타데이터(JSON)로 로딩할 수 있게 한다. GIF는 개발 검수용이며 런타임 필수 자산이 아니다.

- TBD: 전체 캐릭터 공통 렌더 높이, 최종 네이티브 픽셀 크기, 커스터마이징 의상 레이어 규격.

frontend/public/assets/characters/

pengi/walk.png

pengi/meta.json

lulu/walk.png

lulu/meta.json

// 메타데이터 예시

{ "frameWidth": 128, "frameHeight": 160,

"rows": \["down", "left", "right", "up"\],

"framesPerDirection": 4 }

메타데이터의 숫자는 예시다. 캐릭터별 현재 원본 크기가 다르므로 실제 파일 규격으로 기입한다.

# 12. Git · 커밋 · PR 규칙

| 대상       | 규칙                                                            |
|------------|-----------------------------------------------------------------|
| main       | 배포 가능한 안정 코드만 반영                                    |
| develop    | 통합 브랜치 및 다음 릴리스 기반                                 |
| feature/\* | 기능 개발 브랜치, develop에서 분기                              |
| bugfix/\*  | 버그 수정 브랜치, develop에서 분기                              |
| hotfix/\*  | 운영 긴급 수정은 팀 협의 후 main 기준                           |
| 병합       | PR 필수; 리뷰/검사 통과 후 develop 병합                         |
| 커밋       | feat/fix/refactor/docs/test/chore/style 유형 + 한국어 설명 허용 |

feat: 일기 작성 API 구현

fix: 초대코드 중복 처리 오류 수정

refactor: 주민 이동 AI 로직 분리

docs: 코딩 컨벤션 개정

chore: 개발 환경 설정 추가

- MUST: main 직접 커밋 금지, 기능은 feature/\* 브랜치에서 작업한다.

- MUST: PR에는 변경 목적·주요 변경 파일·테스트 방법·DB/API 변경 여부를 기록한다.

- MUST: DB 스키마와 API 계약이 바뀌면 관련 문서도 같은 PR에 반영한다.

- SHOULD: 최소 1명의 다른 팀원이 PR 리뷰. 개발 브랜치에 병합 후 불필요한 feature 브랜치 정리.

- SHOULD: 이미지 바이너리 충돌을 줄이기 위해 게임 에셋 담당 변경 범위를 사전 공유한다.

# 13. 코드 품질 · 테스트 · 보안

- MUST: 민감정보와 .env 실값은 Git에 추가하지 않는다. .env.example만 공유한다.

- MUST: 인증과 그룹 권한을 요청마다 서버에서 검증한다. 업로드 콘텐츠는 유형·크기를 검증한다.

- MUST: 프론트에서 렌더링하는 일기 내용은 XSS에 안전하게 취급한다.

- MUST: 실패 가능 작업에는 예외 처리와 사용자가 이해할 수 있는 실패 메시지를 마련한다.

- SHOULD: ESLint + Prettier, Java formatter, JUnit 5, Vitest, API 통합 테스트를 적용한다.

- SHOULD: 기능별 정상/권한 없음/없는 자원/중복 요청/최대 인원 또는 섬 수 초과를 테스트한다.

# 14. PR 리뷰 체크리스트

☐ 네이밍·폴더 위치·자동 포맷 준수

☐ Controller와 Service, Mapper 역할 분리

☐ 요청·응답 DTO 및 입력 검증 적정

☐ 권한 검사/오류 코드/트랜잭션 검토

☐ 쿼리 매핑 / DB 마이그레이션 / 문서 변경 동기화

☐ 로딩·오류·빈 상태 처리

☐ 테스트 수행 및 결과 첨부

☐ 게임 자산 변경 시 프레임/알파/잘림 검수 자료 첨부

# 15. 미결정 항목과 변경 관리

| TBD 항목                               | 추후 확정 주체/시점             |
|----------------------------------------|---------------------------------|
| 인증·세션 저장 전략                    | 인증 개발 착수 전 팀 합의       |
| Phaser 및 Spring Boot 정확한 패치 버전 | 프로젝트 초기화 시 고정 및 기록 |
| 캐릭터 공통 렌더 크기 / 아틀라스 사용  | 게임 프로토타입 검증 후         |
| 거북섬 성장 및 환생/삭제 정책          | 도메인 설계 후 ERD 확정 전      |
| 스토리지·호스팅·CI 공급자              | 배포 설계 시                    |
| API 페이지네이션 세부 계약             | API 명세 작성 시                |

변경 절차: 제안 이슈 작성 → 팀 합의 → docs/decisions에 이유 기록 → 컨벤션 버전 상승 → 적용 PR 작성.

# 16. 개발 착수 체크리스트

1.  Monorepo 구성 및 .editorconfig / .gitignore / README 생성

2.  Java 17 및 Node 개발 환경 버전 안내, 팀원별 동작 확인

3.  ESLint / Prettier / Java 포맷 설정 공통화

4.  PostgreSQL 접속용 로컬 설정 예시와 첫 마이그레이션

5.  Axios 공통 클라이언트·공통 예외 응답·샘플 API 구성

6.  Vue 라우터 및 게임 씬 기본 뼈대 구축

7.  샘플 스프라이트 애니메이션과 오프라인 주민 AI 로컬 실행 검증

8.  PR 템플릿 / 리뷰 체크리스트 / 브랜치 보호 설정

— 문서 끝 —
