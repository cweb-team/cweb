<%--
  Created by IntelliJ IDEA.
  User: chris
  Date: 2018/4/1
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
                    <el-aside id="vueController-aside">
                        <el-row class="tac">
                            <el-col >
                                <el-menu default-active="2" class="el-menu-vertical-demo" @open="handleOpen" @close="handleClose"
                                         background-color="#545c64" text-color="#fff" active-text-color="#ffd04b"
                                         active-text-color="#ffd04b">
                                    <el-submenu index="1">
                                        <template slot="title">
                                            <span> 任务专栏 </span>
                                        </template>
                                        <el-menu-item-group>
                                            <template slot="title">分组一</template>
                                            <el-menu-item index="1-1">选项1</el-menu-item>
                                            <el-menu-item index="1-2">选项2</el-menu-item>
                                        </el-menu-item-group>
                                        <el-menu-item-group title="分组2">
                                            <el-menu-item index="1-3">选项3</el-menu-item>
                                        </el-menu-item-group>
                                        <el-submenu index="1-4">
                                            <template slot="title">选项4</template>
                                            <el-menu-item index="1-4-1">选项1</el-menu-item>
                                        </el-submenu>
                                    </el-submenu>
                                    <el-menu-item index="2">
                                        <span slot="title">导航二</span>
                                    </el-menu-item>
                                    <el-menu-item index="3" disabled>
                                        <span slot="title">导航三</span>
                                    </el-menu-item>
                                    <el-menu-item index="4">
                                        <span slot="title">导航四</span>
                                    </el-menu-item>
                                </el-menu>
                            </el-col>
                        </el-row>
                    </el-aside>
