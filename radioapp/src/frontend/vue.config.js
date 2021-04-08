
module.exports = {
    devServer: {
        port: 3001, // same as Axios!
        proxy: {
            '/rest': {
                target: "http://localhost:3000",
                ws: true,
                changeOrigin: true,
                secure: false // added
            }
        }
    }
}