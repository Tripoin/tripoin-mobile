package com.tripoin.tripoin_common.component;

/**
 * Created on 9/22/2015 : 4:19 PM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface ITRIPOINTestComponent<TEST_PARAM, TEST_RESULT> extends ITRIPOINComponent<TEST_PARAM> {

    public void setTestResult(TEST_RESULT _result);

    public TEST_RESULT getTestResult();

    public void process();
}
