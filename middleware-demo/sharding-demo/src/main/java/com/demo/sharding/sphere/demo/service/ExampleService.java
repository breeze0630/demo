/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.demo.sharding.sphere.demo.service;

import java.sql.SQLException;

public interface ExampleService {
    
    /**
     * Initialize environment.
     * 
     * @throws SQLException SQL exception
     */
    void initEnvironment() throws SQLException;
    
    /**
     * Clean environment.
     * 
     * @throws SQLException SQL exception
     */
    void cleanEnvironment() throws SQLException;
    
    /**
     * Process success.
     * 
     * @throws SQLException SQL exception
     */
    void processSuccess() throws SQLException;
    
    /**
     * Process failure.
     * 
     * @throws SQLException SQL exception
     */
    void processFailure() throws SQLException;
    
    /**
     * Print data.
     * 
     * @throws SQLException SQL exception
     */
    void printData() throws SQLException;
}
