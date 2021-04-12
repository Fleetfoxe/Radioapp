<template>
  <nav>
      <router-link to="/">Home</router-link>
      -
      <router-link to="/channellist">ChannelList</router-link>
      -
      <router-link to="/categorylist">CategoryList</router-link>
      -
      <router-link to="/programlist">ProgramList</router-link>
  </nav>
</template>

<script>
export default {

}
</script>

<style scoped>
nav {
  font-size: 40px;
  padding: 5px;
  background-color: lightblue;
  border-bottom: 2px solid lightgray;
  color: black;
}


a {
  color: white
}

a:hover {
  color: rgb(8, 8, 8);
}

</style>