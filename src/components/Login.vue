<template>
    <div class="container m-5">
      <form @submit.prevent="UserLogin">
        <h3>登入</h3>
  
        <div class="form-group">
            <label>手機號碼</label>
            <input
            type="text"
            class="form-control form-control-lg"
            v-model="user.phone"
            />
        </div>
  
        <div class="form-group">
          <label>密碼</label>
          <input
            type="password"
            class="form-control form-control-lg"
            v-model="user.password"
          />
        </div>
  
        <button type="submit" class="btn btn-dark btn-lg btn-block">登入</button>
        <button class="btn btn-dark btn-lg btn-block">
          <router-link to="/register">
            註冊
          </router-link>
        </button>
  
        <p class="forgot-password text-right mt-2 mb-4">
          <router-link to="/forgot-password">忘記密碼?</router-link>
        </p>
      </form>
    </div>
  </template>
  
  <script>
  import axios from 'axios';
  export default {
    name: 'UserLogin',
    data() {
        return {
            user: {
                email: "",
                password: "",
            },
        };
    },
    methods: {
        userLogin() {
            axios.post('/api/login', this.user)
            .then(() => {
                this.$router.push("/home");
            })
            .catch(error => {
                console.error(error.response.data.message);
            });
        },
    },
};
</script>