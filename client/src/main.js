import { createApp } from 'vue'
import './style.css'
import './css/font.css'
import App from './App.vue'

// Import Router
import router from './routers/index.js'

const app = createApp(App);

app.use(router);
app.mount('#app');