/*
Copyright 2016 Goldman Sachs.
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing,
software distributed under the License is distributed on an
"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
KIND, either express or implied.  See the License for the
specific language governing permissions and limitations
under the License.
*/

package bitemporalbank.app;

import com.gs.fw.common.mithra.MithraManager;
import com.gs.fw.common.mithra.MithraManagerProvider;

import java.io.InputStream;

public class BitemporalBankApp
{
    public BitemporalBankApp() throws Exception
    {
        this.initReladomo();
    }

    public static void main(String[] args) throws Exception
    {
        new BitemporalBankApp().start();
    }

    private void initReladomo() throws Exception
    {
        MithraManager mithraManager = MithraManagerProvider.getMithraManager();
        mithraManager.setTransactionTimeout(60 * 1000);
        loadReladomoXML("BitemporalBankRuntimeConfiguration.xml");
    }

    private void loadReladomoXML(String fileName) throws Exception
    {
        InputStream stream = BitemporalBankApp.class.getClassLoader().getResourceAsStream(fileName);
        if (stream == null)
        {
            throw new Exception("Failed to locate " + fileName + " in classpath");
        }
        MithraManagerProvider.getMithraManager().readConfiguration(stream);
        stream.close();
    }

    private void start()
    {
        //implement app logic
    }
}
