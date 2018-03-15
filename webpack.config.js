const path = require('path'),
      webpack = require('webpack'),
      ExtractTextPlugin = require("extract-text-webpack-plugin");

var loginLoader = {
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
            filename: 'public/css/companyLogin.css',
            allChunks: true,
        }),
        new webpack.optimize.UglifyJsPlugin({
            compress: {
                warnings: false
            }
        })
    ]
};

var loginConfig = Object.assign({}, loginLoader, {
    name: "login",
    entry: [ 
            './frontend/js/login.js',
            './frontend/sass/companyLogin.scss',
    ] ,
    output: {
        //path: 'public/js',
        filename: 'public/js/login.js'
    }
});

var mainLoader = {
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
            filename: 'public/css/main.css',
            allChunks: true,
        }),
        new webpack.optimize.UglifyJsPlugin({
            compress: {
                warnings: false
            }
        })
    ]
};

var mainConfig = Object.assign({}, mainLoader, {
    name: "main",
    entry: [
        './frontend/js/main.js',
        './frontend/sass/main.scss',
    ] ,
    output: {
        //path: 'public/js',
        filename: 'public/js/main.js'
    }
});

var commonJsLoader = {
    // TODO: Add common Configuration
    module: {
        rules: []
    },
    plugins: [
        new webpack.optimize.UglifyJsPlugin({
            compress: {
                warnings: false
            },
            mangle: true
        })
    ]
};

var commonJsConfig = Object.assign({}, commonJsLoader, {
    name: "common",
    entry: [
        './frontend/js/common/upload.js',
    ] ,
    output: {
        filename: 'public/js/common/upload.js'
    }
});

module.exports = [
    //loginConfig, mainConfig
    //commonJsConfig
    loginConfig
];