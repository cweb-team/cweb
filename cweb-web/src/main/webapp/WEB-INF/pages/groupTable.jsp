<%@ page contentType="text/html;charset=UTF-8" language="java" %>

                    <div id="groupTeam-container">
                        <div id="searchGroup-container">
                            <input placeholder="输入关键字进行查询">
                            <button>
                                查询
                            </button>
                        </div>
                        <table  id='groupTeam-table' class="pure-table pure-table-horizontal">
                            <thead>
                            <tr>
                                <th>团队id</th>
                                <th>团队id</th>
                                <th>团队id</th>
                                <th>团队id</th>
                                <th>团队id</th>
                                <th>团队id</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr >
                                <td>1</td>
                                <td>1</td>
                                <td>1</td>
                                <td>1</td>
                                <td>1</td>
                            </tr>
                            </tbody>
                        </table>
                        <div class ="group-table-page">
                            <ul>
                                <li v-if="currentPage>1"><span v-on:click="currentPage--,pageClick()" >上一页</span></li>
                                <li v-if="currentPage == 1"><span class="banClick">上一页</span></li>
                                <li v-for="item in allPageComputed"  v-bind:class="{ 'active': currentPage == item}">
                                    <span v-on:click="btnClick(item)">{{ item }}</span>
                                </li>
                                <li v-if="currentPage != allPage"><span v-on:click="currentPage++,pageClick()" >下一页</span></li>
                                <li v-if="currentPage == allPage"><span class="banClick">下一页</span></li>
                                <li><span class="banClick">共<i>{{ allPage }}</i>页</span></li>
                            </ul>
                        </div>
                    </div>


