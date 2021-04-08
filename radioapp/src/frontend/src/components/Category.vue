<template>


    <div class="category-list wrapper">
        <span class="name">{{ listCategories }}</span>
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

<!---
<style scoped>

.category-list {
  background-color: lightgray;
  margin-bottom: 20px;
  padding: 10px;
  font-family: 'Arial', cursive;
  border-radius: 30px;
  border: 5px solid whitesmoke;
}

.name {

  font-size: 25px;
   text-shadow: 2px 2px #ffffff;
}


</style> --->
