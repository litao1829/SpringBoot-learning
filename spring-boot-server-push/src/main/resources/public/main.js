
const main={
    data(){
        return{
            message:'hello websocket',
            id:'',
            content:'',
            ws:null
        }
    },
    methods:{
        open(){
            console.log("open")
            this.ws=new WebSocket(`ws://localhost:8080/socket/${this.id}`);
            this.ws.onopen=()=>{
                console.log("websocket连接成功")
            }
            this.ws.onclose=()=>{
                console.log("websocket连接关闭")
            }
            this.ws.onerror=()=>{
                console.log("websocket出现异常")
            }
            this.ws.onmessage=(msg)=>{
                console.log(msg);
                this.message+="\n"
                this.message=this.message.concat(msg.data);
            }
        },
        sendMsg(){
            console.log("send");
            this.ws.send(this.content);
            this.content='';
        }

    },
    computed:{
        isstate(){
            return this.ws!=null;
        }
    }
}
const  app =Vue.createApp(main);

