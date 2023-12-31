import './assets/main.css';
import 'bootstrap/dist/js/bootstrap.js';
import 'bootstrap/dist/css/bootstrap.min.css';
import { createApp } from 'vue';
import { createPinia } from 'pinia';
import { DatePicker } from 'ant-design-vue';
import 'ant-design-vue/dist/reset.css';
import 'tailwindcss/tailwind.css';
import App from './App.vue';
import router from './router';
import vuex from 'vuex';
import stores from '@/stores/index';
const app = createApp(App);

app.use(DatePicker);
app.use(createPinia());
app.use(router);
app.use(vuex);
app.use(stores);

app.mount('#app');
