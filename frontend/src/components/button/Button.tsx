import React, { MouseEventHandler } from 'react';
import styles from './Button.module.css';

interface ButtonProps {
  label: string;
  className?: string;
  id?: string;
  size?: 'default' | 'small' | 'large';
  onClick?: React.MouseEventHandler<HTMLButtonElement>;
}

const fontSizeMapper = Object.freeze({
  small: 15,
  default: 16,
  large: 18,
});

const Button: React.FC<ButtonProps> = ({ id, label, size = fontSizeMapper['default'], onClick }) => {
  return (
    <button
      id={id}
      className={styles.btn}
      style={{
        fontSize: size,
      }}
      onClick={onClick}
    >{label}</button>
  );
};

export default Button;