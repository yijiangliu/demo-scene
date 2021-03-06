/**
 * Copyright 2018 Confluent Inc.
 * <p>
 * Licensed under the GNU AFFERO GENERAL PUBLIC LICENSE, Version 3.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://opensource.org/licenses/AGPL-3.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 **/
package io.confluent.kpay;

import io.confluent.kpay.metrics.model.ThroughputStats;
import io.confluent.kpay.payments.model.AccountBalance;
import io.confluent.kpay.payments.model.ConfirmedStats;
import io.confluent.kpay.payments.model.InflightStats;
import io.confluent.kpay.util.Pair;
import java.util.List;

interface KPay {

    /**
     * Control plane
     * @return
     */
    String status();

    String pause();

    String resume();

    String shutdown();

    /**
     * Data simulation
     * @param ratePerSecond
     */
    void generatePayments(int ratePerSecond);

    void stopPayments();

    boolean isGeneratingPayments();

    /**
     * Trust plane: instrumentation and dql's
     * @return
     */
    ThroughputStats viewMetrics();
    Pair<InflightStats, ConfirmedStats> getPaymentPipelineStats();

    /**
     * Business plane
     * @return
     */
    List<AccountBalance> listAccounts();
    String showAccountDetails(String accountName);


}
