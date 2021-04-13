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
            password: '',
            name: 'Bob'
        }

    },
    methods: {
        async login() {
            //Putting email/password in credentials and change special signs like @
            const credentials = 'username=' + 
            encodeURIComponent(this.email)
            + '&password=' +
            encodeURIComponent(this.password)

            //Login to backend using email/password in credentials
        let response = await fetch("/login", {
            method: "POST",
            headers: { "Content-Type": "application/x-www-form-urlencoded" },
            mode: 'no-cors',
            body: credentials
      });
            //Using backend WhoAmI to se who is logged in to backend
        let user = await fetch('/auth/whoami')
        try{
            user = await user.json()
            
            //save user in store using setLoggedInUser mutation
            this.$store.commit('setLoggedInUser', user)
            console.log(user.email +" is logged in")
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
                password: this.password,
                name: this.name
            }

            let response = await fetch('/auth/register', {
            method: 'POST',
            headers: {'Content-Type': 'application/json' },
            body: JSON.stringify(credentials)
        })
        console.log('Response from register: '+response)
        }
    }
}
</script>

<style>

</style>