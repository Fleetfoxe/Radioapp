<template>
  <div class="channel-card" @click="redirectToProgramsInChannel">

    <div class="title-rating wrapper">
      <span class="title">{{ channel.title }}</span><br>
      <span>{{ channel.genre }}</span>
    </div>
    <br>
    <div class="desc wrapper">
      <p>{{ channel.desc }}</p>
    </div>

  </div>
</template>

<script>
export default {
  props: ["channel"],
   methods: {
    redirectToProgramsInChannel() {
      this.$router.push({ path: '/programsinchannel' });
    }
  }
  };
</script>

<style scoped>

.channel-card {
  background-color: lightgray;
  margin-bottom: 20px;
  padding: 10px;
  font-family: 'Arial', cursive;
  border-radius: 30px;
  border: 5px solid whitesmoke;
}

.title {
  font-size: 25px;
   text-shadow: 2px 2px #ffffff;
}

p {
  color: black;
}

</style>
