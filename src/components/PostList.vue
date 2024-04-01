<template>
    <div class="post-list">
      <h1>Posts</h1>
      <ul>
        <li v-for="post in posts" :key="post.id">{{ post.content }}</li>
      </ul>
    </div>

    <div>
    <form @submit.prevent="addPost">
      <textarea v-model="newPostContent"></textarea>
      <button type="submit">發布帖子</button>
    </form>
    </div>

  </template>

  <script>
  import axios from 'axios';
  export default {
    data() {
      return {
        posts: [],
        newPostContent: ''
      };
    },
    methods: {
        addPost() {
            axios.post('/api/posts', { content: this.newPostContent })
            .then(() => {
                this.newPostContent = '';
                this.fetchPosts();
            })
            .catch(error => {
                console.error(error.response.data.message);
            });
        },
        fetchPosts() {
            axios.get('/api/posts')
            .then(response => {
                this.posts = response.data;
            })
            .catch(error => {
                console.error(error.response.data.message);
            });
        },
    },
};
</script>