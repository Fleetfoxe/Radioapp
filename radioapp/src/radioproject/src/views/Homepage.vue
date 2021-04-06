<template>
  <div id="wrapper">
<h1>Home</h1>
  </div>
</template>

<script>

import ChannelList from "./ChannelList.vue"

export default {
    name: "homepage",
    components: {
      ChannelList
    }
}
</script>

<style scoped>

#wrapper {
  background-color: lightgray;
  padding-top: 25px;
  padding-bottom: 100px;
  color: black;
  border-radius: 50px;
  margin-bottom: 20px;
}

h1 {
  font-family: 'Arial';
  text-align: center;
  color: black;
  margin-bottom: 25px;
}

</style>