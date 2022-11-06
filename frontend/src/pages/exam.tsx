import { Link } from 'react-router-dom';
import { Button } from '../components';
import '../assets/style.css';
import CheckableTagsInput from "../components/input/CheckableTagsInput";
import { Code } from '../model/components/input';

const options: Code[] = [
  { label: 'Code 1', value: 'code 1' },
  { label: 'Code 2', value: 'code 2' },
  { label: 'Code 3', value: 'code 3' },
  { label: 'Code 4', value: 'code 4' },
];

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

    <div>
      <h1>Input</h1>
      <h2>CheckableTagsInput</h2>
      <div className="wrap">
        <CheckableTagsInput options={options} />
      </div>

    </div>
  </div>
);

export default Exam;