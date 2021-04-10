<template>
<form @submit.prevent="login">
    <input v-model="email" type="text" placeholder="email" required>
    <input v-model="password" type="password" placeholder="password" required>
    <button>Login</button>
    <button type="button" @click="register">Register</button>
</form>
</template>

<script>
export default {
    data() {
        return {
            email: '',
            password: ''
        }

    },
    methods: {
        async login() {
            const credentials = 'username=' + 
            encodeURIComponent(this.email)
            + '&password=' +
            encodeURIComponent(this.password)

        let response = await fetch("/login", {
            method: "POST",
            headers: { "Content-Type": "application/x-www-form-urlencoded" },
            mode: 'no-cors',
            body: credentials
      });

        let user = await fetch('/auth/whoami')
        try{
            user = await user.json()
            this.$store.commit('setLoggedInUser', user)
            console.log(user)
        } catch {
             alert('Wrong username/password');
        }
        

        if(response.url.includes('error')) {
            console.log('Wrong username/password');
            }

        },

        async register() {
            let credentials = {
                email: this.email,
                password: this.password
            }

            let response = await fetch('/auth/register', {
            method: 'POST',
            headers: {'Content-Type': 'application/json' },
            body: JSON.stringify(credentials)
        })
        console.log('Response from regiter: '+response)
        }
    }
}
</script>

<style>

</style>