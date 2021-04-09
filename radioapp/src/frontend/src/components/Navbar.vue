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
  padding: 5px;
  background-color: lightblue;
  border-bottom: 2px solid lightgray;
  color: white;
}
a {
  color: white
}

a:hover {
  color: black;
}

</style>