<template>


    <div class="category-card" @click="redirectToCategoryDetails">
        <h2>          
            <span>{{ category.name }}</span>
        </h2>
        
    </div>
</template>

<script>
export default {
    props: ["category"],
    methods: {
        redirectToCategoryDetails() {
            this.$store.commit("setTempCategoryName", this.category.name)
            let routerUrl = '/category-details/' + this.category.id
            this.$router.push({path: routerUrl})

        }
    }
    
}
</script>

<style>




</style>