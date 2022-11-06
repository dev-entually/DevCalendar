import React from 'react';
import styles from './Button.module.css';

interface ButtonProps {
  label: string;
  size?: 'default' | 'small' | 'large';
  onClick?: () => void;
}

const fontSizeMapper = Object.freeze({
  small: 15,
  default: 16,
  large: 18,
});

const Button: React.FC<ButtonProps> = ({ label, size = fontSizeMapper['default'], onClick }) => {
  return (
    <button
      className={styles.btn}
      style={{
        fontSize: size,
      }}
      onClick={onClick}
    >{label}</button>
  );
};

export default Button;