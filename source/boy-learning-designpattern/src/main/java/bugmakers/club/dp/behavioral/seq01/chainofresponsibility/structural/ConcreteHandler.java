package bugmakers.club.dp.behavioral.seq01.chainofresponsibility.structural;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/15 20:16
 */
public class ConcreteHandler extends Handler {

    @Override
    public void handleRequest(String request) {

        boolean i_can_handle_this_request = true;

        if(i_can_handle_this_request){

            // 处理请求

        }else{
            this.successor.handleRequest(request);
        }
    }
}
