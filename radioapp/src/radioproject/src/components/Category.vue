<template>


    <div class="category-list wrapper">
        <span class="name">{{ category.name }}</span>
        <br>
    </div>
</template>

<script>
export default {
    props: ["category"],
    methods: {
        listCategories() {
            this.$router.push({ path: '/categoryList' });
        }
    }
};
</script>


<style scoped>

.category-card {
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