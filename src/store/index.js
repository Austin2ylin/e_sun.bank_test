import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    isLoggedIn: false,
    currentUser: null,
    posts: []
  },
  mutations: {
    setUser(state, user) {
      state.isLoggedIn = !!user;
      state.currentUser = user;
    },
    setPosts(state, posts) {
      state.posts = posts;
    }
  },
  actions: {
    login({ commit }, user) {
      commit('setUser', user);
    },
    fetchPosts({ commit }) {
    }
  }
});

