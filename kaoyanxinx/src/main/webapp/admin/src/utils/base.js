const base = {
    get() {
                return {
            url : "http://localhost:8080/ssmAg4LG/",
            name: "ssmAg4LG",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/ssmAg4LG/front/index.html'
        }
            },
    getProjectName(){
        return {
            projectName: "考研信息查询系统"
        } 
    }
}
export default base