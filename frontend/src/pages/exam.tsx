import { Link } from 'react-router-dom';
import { Button } from '../components';
import '../assets/style.css';

const Exam = () => (
  <div>
    <div>
      <h1>React Router</h1>
      <h2>Link</h2>
      <Link to="/">Home</Link>
    </div>

    <div>
      <h1>Button</h1>
      <h2>Size</h2>
      <div className="wrap">
        <Button label="small" size="small" />
        <Button label="default" />
        <Button label="large" size="large" />
      </div>

      <h2>Event</h2>
      <div className="wrap">
        <Button label="onClick" onClick={() => console.log('Button is clicked.')}/>
      </div>
    </div>
  </div>
);

export default Exam;