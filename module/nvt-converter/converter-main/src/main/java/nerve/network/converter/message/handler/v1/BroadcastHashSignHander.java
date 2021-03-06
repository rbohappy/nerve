/**
 * MIT License
 * <p>
 Copyright (c) 2019-2020 nerve.network
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package nerve.network.converter.message.handler.v1;

import io.nuls.base.RPCUtil;
import io.nuls.base.protocol.MessageProcessor;
import nerve.network.converter.constant.ConverterCmdConstant;
import nerve.network.converter.core.business.MessageService;
import nerve.network.converter.message.BroadcastHashSignMessage;
import io.nuls.core.core.annotation.Component;

/**
 * @author: Chino
 * @date: 2020-02-27
 */
@Component("BroadcastHashSignHandlerV1")
public class BroadcastHashSignHander implements MessageProcessor {

    private MessageService messageService;

    @Override
    public String getCmd() {
        return ConverterCmdConstant.NEW_HASH_SIGN_MESSAGE;
    }

    @Override
    public void process(int chainId, String nodeId, String message) {
        BroadcastHashSignMessage broadcastHashSignMessage = RPCUtil.getInstanceRpcStr(message, BroadcastHashSignMessage.class);
        if(null == broadcastHashSignMessage){
            return;
        }
        messageService.newHashSign(chainId, nodeId, broadcastHashSignMessage);
    }
}
