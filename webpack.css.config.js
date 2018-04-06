const path = require('path'),
    webpack = require('webpack'),
    ExtractTextPlugin = require("extract-text-webpack-plugin");

var cssLoader = {
    // TODO: Add common Configuration
    module: {
        rules: [
            {
                test: /\.scss$/,
                loader: ExtractTextPlugin.extract(["postcss-loader",'sass-loader'])
            }
        ]
    },
    plugins: [
        new ExtractTextPlugin({ // define where to save the file

            filename: 'cweb-web/src/main/webapp/statics/css/register.css',

            allChunks: true,
        }),
        new webpack.optimize.UglifyJsPlugin({
            compress: {
                warnings: false
            }
        })
    ]
};

var css = Object.assign({}, cssLoader, {
    name: "css",
    entry: [
        './cweb-web/src/main/webapp/statics/scss/register.scss',       //入口文件必须./ 绝对路径
    ] ,
    output: {
        //path: 'public/js',
        filename: 'cweb-web/src/main/webapp/statics/css/register.css'

    }
});

module.exports = [
    css
];