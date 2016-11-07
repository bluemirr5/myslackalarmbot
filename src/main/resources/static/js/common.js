/**
 * Created by gyeshinwon on 2016. 11. 7..
 */
var Menu = React.createClass({
    getInitialState: function () {
        return {
            selectedIndex: 0
        };
    },
    render: function () {
        return (
            <nav className="navbar navbar-inverse navbar-fixed-top">
                <div className="container">
                    <div className="navbar-header">
                        <button type="button" className="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span className="sr-only">Toggle navigation</span>
                        <span className="icon-bar"></span>
                        <span className="icon-bar"></span>
                        <span className="icon-bar"></span>
                        </button>
                        <a className="navbar-brand" href="#">My Slack Alarm Bot</a>
                    </div>
                    <div id="navbar" className="collapse navbar-collapse">
                        <ul className="nav navbar-nav">
                        <li className="active"><a href="#">Test Page</a></li>
                        <li><a href="#about">준비1</a></li>
                        <li><a href="#contact">준비2</a></li>
                        </ul>
                    </div>
                </div>
            </nav>
        );
    }
});

ReactDOM.render(
    <Menu />,
    document.getElementById('menu')
);